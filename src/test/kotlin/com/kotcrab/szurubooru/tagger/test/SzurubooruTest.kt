package com.kotcrab.szurubooru.tagger.test

import com.kotcrab.szurubooru.tagger.Szurubooru
import com.kotcrab.szurubooru.tagger.SzurubooruDto
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Ignore
import org.junit.Test

/**
 * Szurubooru integration test, due to need of having local instance of Szurubooru running, those tests are disabled by default.
 * @author Kotcrab
 */
@Ignore
class SzurubooruTest {
    @Test
    fun testHostReachable() {
        assertTrue(Szurubooru(SzurubooruDto()).isHostReachable())
    }

    @Test
    fun testAuthorized() {
        assertTrue(Szurubooru(SzurubooruDto()).isAuthorized())
    }

    @Test
    fun testNotAuthorizedNoSuchUser() {
        val dto = SzurubooruDto()
        dto.username = "not-a-user"
        dto.password = "not-a-password"
        assertFalse(Szurubooru(dto).isAuthorized())
    }

    @Test
    fun testNotAuthorizedInvalidPassword() {
        val dto = SzurubooruDto()
        dto.username = "auto-tagger"
        dto.password = "not-a-password"
        assertFalse(Szurubooru(dto).isAuthorized())
    }

    @Test
    fun testGetTagCategories() {
        Szurubooru(SzurubooruDto()).getTagCategories()
    }

    @Test
    fun testGetTags() {
        val tags = Szurubooru(SzurubooruDto()).getTags()
        assertTrue(tags.size != 0)
        assertTrue(tags.contains("tagme"))
    }

    @Test
    @Ignore
    fun batchUpload() {
//      Szurubooru(getLocalDto()).post("post/2/").ignoreHttpErrors(true).method(Connection.Method.DELETE).execute().body()
//        val szuru = Szurubooru(getLocalDto())
//        File("""C:\Users\Kotcrab\Desktop\boorutest""").listFiles().forEach {
//            println("Upload ${it.name}")
//            szuru.uploadFile(it, Szurubooru.Safety.Safe, "auto_tagme")
//        }
    }
}
