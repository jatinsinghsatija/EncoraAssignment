package com.example.encoraassignment.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text
@Root(name = "category", strict = false)
data class Category(
    @field:Attribute(name = "id") var imId: String?= null,
    @field:Attribute(name = "term") var categoryTerm: String?= null,
    @field:Attribute(name = "scheme") var scheme: String?= null,
    @field:Attribute(name = "label") var categoryLabel: String?= null
)