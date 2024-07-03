package com.example.motivationapp.data

import com.example.motivationapp.infra.MotivationConstants

class Phrase(val description: String, val categoryId: Int)

class Mock {

    private val all = MotivationConstants.FILTER.ALL
    private val happy = MotivationConstants.FILTER.HAPPY
    val bookMark = MotivationConstants.FILTER.BOOKMARK

    val mListPhrase = listOf<Phrase>(
        Phrase("Não sabendo que era impossível, foi lá e fez.", happy),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", happy),
        Phrase("Quando está mais escuro, vemos mais estrelas!", happy),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", happy),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", happy),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", bookMark),
        Phrase("Você perde todas as chances que você não aproveita.", bookMark),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", bookMark),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", bookMark),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", bookMark),
        Phrase("Se você acredita, faz toda a diferença.", bookMark),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", bookMark)
    )

    fun getPhrase(id: Int) : String {
        val listCategory = mListPhrase.filter { (it.categoryId == id || id == all) }

        val numberOfList = listCategory.count()
        val numberRandom : Int = (0..numberOfList).random()

        return listCategory[numberRandom].description
    }

}