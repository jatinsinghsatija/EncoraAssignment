package com.example.encoraassignment.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text
@Root(name = "contentType", strict = false)
data class ContentType(
    @field:Attribute(name = "term", required = false) var contentTerm: String?= null,
    @field:Attribute(name = "label", required = false) var contentLabel: String?= null
)