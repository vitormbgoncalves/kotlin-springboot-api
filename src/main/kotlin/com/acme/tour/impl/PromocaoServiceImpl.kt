package com.acme.tour.impl

import com.acme.tour.model.Promocao
import com.acme.tour.repository.PromocaoRepository
import com.acme.tour.service.PromocaoService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
@Component
  open class PromocaoServiceImpl(val promocaoRepository: PromocaoRepository): PromocaoService {

  @CacheEvict("promocoes", allEntries = true)
  override fun create(promocao: Promocao) {
    promocaoRepository.save(promocao)
  }

  override fun getById(id: Long): Promocao? {
    return promocaoRepository.findById(id).orElseGet(null)
  }

  @CacheEvict("promocoes", allEntries = true)
  override fun delete(id: Long) {
    promocaoRepository.deleteById(id)
  }

  @CacheEvict("promocoes", allEntries = true)
  override fun update(id: Long, promocao: Promocao) {
    create(promocao)
  }

  override fun searchByLocal(local: String): List<Promocao> =
    listOf()

  @Cacheable("promocoes")
  override fun getAll(start: Int, size: Int): List<Promocao> {
    val pageable = PageRequest.of(start, size, Sort.by("local").ascending())
    return promocaoRepository.findAll(pageable).toList()
  }
  override fun count(): Long = promocaoRepository.count()

  override fun getAllSortedByLocal(): List<Promocao> =
    promocaoRepository.findAll(Sort.by("local").descending()).toList()

  override fun getAllByPrecoMenorQue(preco: Double): List<Promocao> {
    return promocaoRepository.findByPrecoMenorQue(preco)
  }
}