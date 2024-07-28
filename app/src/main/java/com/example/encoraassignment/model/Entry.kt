package com.example.encoraassignment.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text
@Root(name = "entry", strict = false)
data class Entry(


    @field:Element(name = "id", required = false) var entryId: String?= null,
    @field:Element(name = "title", required = false) var title: String?= null,
    @field:Element(name = "name", required = false) var imName: String?= null,
    @field:Element(name = "category", required = false) var category: Category?=null,
    @field:Element(name = "artist", required = false) var imArtist: String?= null,

    @field:Element(name = "price", required = false) var imPrice: Price? = null,
    @field:ElementList(name = "link",inline=true, required = false) var link: List<Link>? = null,
    @field:ElementList(name = "image", inline=true,required=false) var imImages: List<Image>? = null,
    @field:Element(name = "rights", required = false) var rights: String?= null,
    @field:Element(name = "releaseDate", required = false) var imReleaseDate: String?= null,
    //@field:Element(name = "collection", required = false) var imCollection: Collection? = null,
    @field:Element(name = "content", required = false) var content: String?= null
)