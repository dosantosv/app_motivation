package com.example.motivationapp.data

import com.example.motivationapp.infra.MotivationConstants

class Phrase(val description: String, val categoryId: Int, val lang: String)

class Mock {

    private val all = MotivationConstants.FILTER.ALL
    private val happy = MotivationConstants.FILTER.HAPPY
    val bookMark = MotivationConstants.FILTER.BOOKMARK

    private val langPt = MotivationConstants.LANGUAGE.PORTUGUESE
    private val langEn = MotivationConstants.LANGUAGE.ENGLISH
    private val langFr = MotivationConstants.LANGUAGE.FRENCH

    private val listPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", happy, langPt),
        Phrase(
            "Você não é derrotado quando perde, você é derrotado quando desiste!",
            happy,
            langPt
        ),
        Phrase("Quando está mais escuro, vemos mais estrelas!", happy, langPt),
        Phrase(
            "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
            happy,
            langPt
        ),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy, langPt),
        Phrase(
            "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
            happy,
            langPt
        ),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", bookMark, langPt),
        Phrase("Você perde todas as chances que você não aproveita.", bookMark, langPt),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", bookMark, langPt),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", bookMark, langPt),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", bookMark, langPt),
        Phrase("Se você acredita, faz toda a diferença.", bookMark, langPt),
        Phrase(
            "Riscos devem ser corridos, porque o maior perigo é não arriscar nada!",
            bookMark,
            langPt
        ),
        Phrase("Not knowing it was impossible, he went there and did it.", happy, langEn),
        Phrase(
            "You are not defeated when you lose, you are defeated when you give up!",
            happy,
            langEn
        ),
        Phrase("When it's darker, we see more stars!", happy, langEn),
        Phrase(
            "Insanity is always doing the same thing and expecting a different result.",
            happy,
            langEn
        ),
        Phrase("Don't stop when you're tired, stop when you're done.", happy, langEn),
        Phrase("What can you do now that has the biggest impact on your success?", happy, langEn),
        Phrase("The best way to predict the future is to invent it.", bookMark, langEn),
        Phrase("You lose every chance you don't take.", bookMark, langEn),
        Phrase("Failure is the spice that flavors success.", bookMark, langEn),
        Phrase(" As long as we are not committed, there will be hesitation!", bookMark, langEn),
        Phrase("If you don't know where you want to go, any way will do.", bookMark, langEn),
        Phrase("If you believe, it makes all the difference.", bookMark, langEn),
        Phrase(
            "Risks must be taken, because the greatest danger is not risking anything!",
            bookMark,
            langEn
        ),
        Phrase("Ne sachant pas que c'était impossible, il y est allé et l'a fait.", happy, langFr),
        Phrase(
            "Tu n'es pas vaincu quand tu perds, tu es vaincu quand tu abandonnes!",
            happy,
            langFr
        ),
        Phrase("Quand il fait plus sombre, on voit plus d'étoiles!", happy, langFr),
        Phrase(
            "La folie, c'est toujours faire la même chose et s'attendre à un résultat différent.",
            happy,
            langFr
        ),
        Phrase("Ne t'arrête pas quand tu es fatigué, arrête quand tu as fini.", happy, langFr),
        Phrase(
            "Que pouvez-vous faire maintenant qui a le plus grand impact sur votre succès?",
            happy,
            langFr
        ),
        Phrase("La meilleure façon de prédire l'avenir est de l'inventer.", bookMark, langFr),
        Phrase("Vous perdez toutes les chances que vous ne prenez pas.", bookMark, langFr),
        Phrase("L'échec est l'épice qui parfume le succès.", bookMark, langFr),
        Phrase("Tant qu'on n'est pas engagé, il y aura des hésitations!", bookMark, langFr),
        Phrase(
            "Si vous ne savez pas où vous voulez aller, n'importe quoi fera l'affaire.",
            bookMark,
            langFr
        ),
        Phrase("Si vous croyez, cela fait toute la différence.", bookMark, langFr),
        Phrase(
            "Il faut prendre des risques, car le plus grand danger est de ne rien risquer!",
            bookMark,
            langFr
        )
    )

    fun getPhrase(id: Int, lang: String) : String {
        val listCategory = listPhrases.filter {
            (it.categoryId == id || id == all) && it.lang == lang  }

        val numberOfList = listCategory.count()
        val numberRandom : Int = (0..numberOfList).random()

        return listCategory[numberRandom].description
    }

}