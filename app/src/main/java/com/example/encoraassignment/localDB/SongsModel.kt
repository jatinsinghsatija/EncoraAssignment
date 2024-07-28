package com.example.encoraassignment.localDB

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.encoraassignment.model.Category
import com.example.encoraassignment.model.Collection
import com.example.encoraassignment.model.Image
import com.example.encoraassignment.model.Price
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import java.io.Serializable


@Entity
class SongsModel : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    @ColumnInfo(name = "songId")
    var songId: String? = null

    @ColumnInfo(name = "title")
    var title: String? = null
    @ColumnInfo(name = "name")
    var name: String? = null
    @ColumnInfo(name = "categoryId")
    var categoryId: String? = null
    @ColumnInfo(name = "term")
    var term: String? = null
    @ColumnInfo(name = "scheme")
    var scheme: String? = null
    @ColumnInfo(name = "label")
    var label: String? = null
    @ColumnInfo(name = "artist")
    var artist: String? = null
    @ColumnInfo(name = "amount")
    var amount: String? = null
    @ColumnInfo(name = "currency")
    var currency: String? = null
    @ColumnInfo(name = "rights")
    var rights: String? = null
    @ColumnInfo(name = "releaseDate")
    var releaseDate: String? = null
    @ColumnInfo(name = "content")
    var content: String? = null
    @ColumnInfo(name = "image55")
    var image55: String? = null
    @ColumnInfo(name = "image60")
    var image60: String? = null
    @ColumnInfo(name = "image170")
    var image170: String? = null
    //@ColumnInfo(name = "collectionName")
    //var collectionName: String? = null
    @ColumnInfo(name = "audioRef")
    var audioRef: String? = null


    //@ColumnInfo(name = "collectionTerm")
    //var collectionTerm: String? = null

    //@ColumnInfo(name = "collectionLabel")
    //var collectionLabel: String? = null
}