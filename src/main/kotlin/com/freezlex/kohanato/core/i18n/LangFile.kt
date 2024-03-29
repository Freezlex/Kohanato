package com.freezlex.kohanato.core.i18n

import com.freezlex.kohanato.core.GSON
import com.google.gson.JsonObject
import java.io.File

class LangFile(private val lang: String, data: JsonObject) {
    var data: JsonObject = data
        set(value) {
            field = value
            save()
        }

    private fun save() = File("lang/$lang.json").writeText(GSON.toJson(data))

    companion object {
        private val LANG_DIR = File("./lang/")

        init {
            LANG_DIR.mkdirs()
        }

        /**
         * Load lang file
         * @param lang [String] lang code
         */
        fun load(lang: String): LangFile {
            val file = File(LANG_DIR, "$lang.json")
            if (!file.exists()) file.createNewFile()
            val data = GSON.fromJson(file.readText(), JsonObject::class.java) ?: JsonObject()
            return LangFile(lang, data)
        }
    }
}