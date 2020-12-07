package com.acme.tour.controller

import com.acme.tour.exception.PromocaoNotFoundException
import com.acme.tour.model.ErrorMessage
import com.acme.tour.model.Promocao
import com.acme.tour.model.RespostaJSON
import com.acme.tour.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = ["/promocoes"])
class PromocaoController {

  @Autowired
  lateinit var promocaoService: PromocaoService

  @GetMapping("/menorQue/{preco}")
  fun getAllMenores(@PathVariable preco: Double) = promocaoService.getAllByPrecoMenorQue(preco)


  @GetMapping("/{id}")
  fun getById(@PathVariable id:Long): ResponseEntity<Any> {
    var promocao = promocaoService.getById(id)
    return if(promocao != null)
      return ResponseEntity(promocao, HttpStatus.OK)

    else
    return ResponseEntity(ErrorMessage("Promocao nao localizada", "Promocao ${id} não localizada!"), HttpStatus.NOT_FOUND)
  }

  @GetMapping()
  fun getAll(@RequestParam(required = false, defaultValue = "0") start: Int,
             @RequestParam(required = false, defaultValue = "3") size: Int): ResponseEntity<List<Promocao>> {

    val listaPromocao = promocaoService.getAll(start, size)

    val status = if(listaPromocao.size == 0) HttpStatus.NOT_FOUND else HttpStatus.OK
    return ResponseEntity(listaPromocao, status)
  }

  @PostMapping()
  fun create(@RequestBody promocao: Promocao): ResponseEntity<RespostaJSON> {
    promocaoService.create(promocao)
    val respostaJSON = RespostaJSON("OK", Date())
    return ResponseEntity(respostaJSON, HttpStatus.CREATED)
  }

  @DeleteMapping("/{id}")
  fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
    var status = HttpStatus.NOT_FOUND
    if(promocaoService.getById(id) != null) {
      status = HttpStatus.ACCEPTED
      promocaoService.delete(id)
    }
    return ResponseEntity(Unit, status)
  }

  @PutMapping("/{id}")
  fun update(@PathVariable id: Long, @RequestBody promocao: Promocao): ResponseEntity<Unit> {
    var status = HttpStatus.NOT_FOUND
    if(promocaoService.getById(id) != null) {
      promocaoService.update(id, promocao)
      status = HttpStatus.ACCEPTED
    }
    return ResponseEntity(Unit, status)
  }
  @GetMapping("/count")
  fun count(): ResponseEntity<Map<String, Long>> = ResponseEntity.ok().body(mapOf("cont" to promocaoService.count()))

  @GetMapping("/ordenados")
  fun ordenados() = promocaoService.getAllSortedByLocal()
}