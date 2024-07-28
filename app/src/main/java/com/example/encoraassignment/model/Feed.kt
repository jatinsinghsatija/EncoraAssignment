package com.example.encoraassignment.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text

@Root(name = "feed", strict = false)
data class Feed(
    @field:Element(name = "id", required = false) var id: String?= null,
    @field:Element(name = "title", required = false) var title: String?= null,
    @field:Element(name = "updated", required = false) var updated: String?= null,
    @field:Element(name = "icon", required = false) var icon: String?= null,
    @field:Element(name = "rights", required = false) var rights: String?= null,
    @field:ElementList(name = "entry", inline = true, required = false) var entries: List<Entry>? = null
)














