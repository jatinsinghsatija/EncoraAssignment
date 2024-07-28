package com.example.encoraassignment.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text
@Root(name = "image", strict = false)
data class Image(
    @field:Attribute(name = "height", required = false)
    var height: String?= null,

    @field:Text
    var url: String?= null
)