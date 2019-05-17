package com.example.pets.Model

class WalkerModel {
    var name: String? = null
    var comment: String? = null

    constructor() {}

    constructor(name: String, comment: String) {
        this.name = name
        this.comment = comment
    }

    fun toMap(): Map<String, Any> {
        val result = HashMap<String, Any>()
        result.put("name", name!!)
        result.put("comment", comment!!)
        return result
    }
}