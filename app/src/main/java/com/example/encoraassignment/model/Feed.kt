package com.example.encoraassignment.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text

@Root(name = "feed", strict = false)
data class Feed(
    @field:Element(name = "id") var id: String?= null,
    @field:Element(name = "title") var title: String?= null,
    @field:Element(name = "updated") var updated: String?= null,
    @field:Element(name = "icon") var icon: String?= null,
    @field:Element(name = "rights") var rights: String?= null,
    @field:ElementList(name = "entry", inline = true, required = false) var entries: List<Entry>? = null
)

@Root(name = "entry", strict = false)
data class Entry(


    @field:Element(name = "id") var entryId: String?= null,
    @field:Element(name = "title") var title: String?= null,
    @field:Element(name = "name") var imName: String?= null,
    @field:Element(name = "category") var category: Category?=null,
    @field:Element(name = "artist") var imArtist: String?= null,

    @field:Element(name = "price") var imPrice: Price? = null,

    @field:ElementList(name = "image", inline=true,required=false)
    var imImages: List<Image>? = null,
    @field:Element(name = "rights") var rights: String?= null,
    @field:Element(name = "releaseDate", required = false) var imReleaseDate: String?= null,
    
    @field:Element(name = "collection") var imCollection: Collection? = null,
    @field:Element(name = "content") var content: String?= null
)

@Root(name = "image", strict = false)
data class Image(
    @field:Attribute(name = "height")
    var height: String?= null,

    @field:Text
    var url: String?= null
)



@Root(name = "contentType", strict = false)
data class ContentType(
    @field:Attribute(name = "term") var contentTerm: String?= null,
    @field:Attribute(name = "label") var contentLabel: String?= null
)

@Root(name = "category", strict = false)
data class Category(
    @field:Attribute(name = "id") var imId: String?= null,
    @field:Attribute(name = "term") var categoryTerm: String?= null,
    @field:Attribute(name = "scheme") var scheme: String?= null,
    @field:Attribute(name = "label") var categoryLabel: String?= null
)

@Root(name = "price", strict = false)
data class Price(
    @field:Attribute(name = "amount") var amount: String?= null,
    @field:Attribute(name = "currency") var currency: String?= null
)

@Root(name = "collection", strict = false)
data class Collection(
    @field:Element(name = "name") var collectionImName: String?= null,
    
    @field:Element(name = "contentType") var imContentType: ContentType? = null
)
