package com.example.encoraassignment.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text

@Root(name = "link", strict = false)
data class Link(
    @field:Attribute(name = "rel", required = false)
    var rel: String? = null,

    @field:Attribute(name = "type", required = false)
    var type: String? = null,

    @field:Attribute(name = "href", required = false)
    var href: String? = null,

    @field:Attribute(name = "title", required = false)
    var title: String? = null
)