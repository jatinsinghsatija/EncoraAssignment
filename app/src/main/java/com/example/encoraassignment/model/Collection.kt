package com.example.encoraassignment.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text
@Root(name = "collection", strict = false)
data class Collection(
    @field:Element(name = "name", required = false) var collectionImName: String?= null,

    @field:Element(name = "link", required = false)
    var link: Link? = null,
    
    @field:Element(name = "contentType", required = false) var imContentType: ContentType? = null
)