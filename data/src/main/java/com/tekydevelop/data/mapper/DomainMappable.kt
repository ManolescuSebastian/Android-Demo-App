package com.tekydevelop.data.mapper

interface DomainMappable<R> {
    fun asDomain(): R
}