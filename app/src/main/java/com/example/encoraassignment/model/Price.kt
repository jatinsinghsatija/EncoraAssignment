package com.example.encoraassignment.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text

@Root(name = "price", strict = false)
data class Price(
    @field:Attribute(name = "amount", required = false) var amount: String?= null,
    @field:Attribute(name = "currency", required = false) var currency: String?= null
)