package br.com.kotlincoroutine.domain.di

import org.koin.core.module.Module
import org.koin.dsl.module

private val businessModule: Module = module {

}

val domainModule = listOf(businessModule)