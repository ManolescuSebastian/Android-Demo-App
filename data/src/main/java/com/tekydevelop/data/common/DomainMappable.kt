package com.tekydevelop.data.common

interface DomainMappable<R> {
    fun asDomain(): R
}