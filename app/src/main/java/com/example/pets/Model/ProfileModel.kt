package com.example.pets.Model

class ProfileModel {
    var walk: String? = null
    var videos: String? = null
    var following: String? = null
    var mail: String? = null
    var cellPhone: String? = null
    var comment: String? = null

    constructor() {}

    constructor(walk: String, videos: String, following: String, mail: String, cellPhone: String, comment: String) {
        this.walk = walk
        this.videos = videos
        this.following = following
        this.mail = mail
        this.cellPhone = cellPhone
        this.comment = comment
    }

    fun toMap(): Map<String, Any> {
        val result = HashMap<String, Any>()
        result.put("walk", walk!!)
        result.put("videos", videos!!)
        result.put("following", following!!)
        result.put("mail", mail!!)
        result.put("cellPhone", cellPhone!!)
        result.put("comment", comment!!)
        return result
    }

}