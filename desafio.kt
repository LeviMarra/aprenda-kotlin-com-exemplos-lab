// [Template no Kotlin Playground](https://pl.kotl.in/5LusIkGH-)

enum class Nivel { INICIANTE, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val sobrenome: String, val idade: Int, val email: String, val matricula: String) {
    override fun toString(): String {
        return "Nome: $nome $sobrenome, Matrícula: $matricula"
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel) {
    override fun toString(): String {
        return "Nome: $nome\nDuração: $duracao horas\nNível: $nivel"
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        inscritos.addAll(usuarios)
    }
    
    override fun toString(): String {
        val conteudosString = conteudos.joinToString("\n\n") { it.toString() }
        val inscritosString = inscritos.joinToString("\n") { it.toString() }
        val totalInscritos = inscritos.size
        return "\nFormação: $nome\n---------------\nConteúdos:\n$conteudosString\n\nInscritos ($totalInscritos):\n$inscritosString\n---------------"
    }
}

fun main() {
    val usuario1 = Usuario("Levi", "Marra", 28, "levimarra@email.com", "123456")
    val usuario2 = Usuario("Leticia", "Marra", 25, "leticiamarra@email.com", "123455")
    val usuario3 = Usuario("Joana", "Lopes", 35, "jolopes@email.com", "654321")
    val usuario4 = Usuario("Rosilene", "Lopes", 56, "rosilopes@email.com", "789456")
    val usuario5 = Usuario("Jorge", "Rios", 65, "jorgerios@email.com", "654987")
    val usuario6 = Usuario("Rodrigo", "Rios", 24, "rodrigorios@email.com", "789455")
    val usuario7 = Usuario("Gabriel", "Moraes", 26, "gabrielmoraes@email.com", "147852")
    val usuario8 = Usuario("Miguel", "Moraes", 27, "miguelmoraes@email.com", "963852")

    val conteudoKotlin1 = ConteudoEducacional("Introdução Kotlin", 50, Nivel.INICIANTE)
    val conteudoKotlin2 = ConteudoEducacional("Pilares da POO", 70, Nivel.INTERMEDIARIO)
    val formacaoKotlin = Formacao("Programação em Kotlin", listOf(conteudoKotlin1, conteudoKotlin2))
    
    
    val conteudoLogica1 = ConteudoEducacional("Lógica Iniciante", 30, Nivel.INICIANTE)
    val conteudoLogica2 = ConteudoEducacional("Lógica Intermediária", 50, Nivel.INTERMEDIARIO)
    val conteudoLogica3 = ConteudoEducacional("Lógica Avançada", 70, Nivel.AVANCADO)
    val formacaoLogica = Formacao("Lógica de Programação Essencial", listOf(conteudoLogica1, conteudoLogica2, conteudoLogica3))
    
    
    val conteudoDesenvolvimento1 = ConteudoEducacional("Desenvolvimento Android 1", 50, Nivel.INICIANTE)
    val conteudoDesenvolvimento2 = ConteudoEducacional("Desenvolvimento Android 2", 80, Nivel.INTERMEDIARIO)
    val conteudoDesenvolvimento3 = ConteudoEducacional("Desenvolvimento Android 3", 100, Nivel.AVANCADO)
    val conteudoDesenvolvimento4 = ConteudoEducacional("Desenvolvimento Android 4", 120, Nivel.AVANCADO)
    val formacaoDesenvolvimento = Formacao("Desenvolvimento Android Pleno", listOf(conteudoDesenvolvimento1, conteudoDesenvolvimento2, conteudoDesenvolvimento3, conteudoDesenvolvimento4))
    

    formacaoKotlin.matricular(usuario1, usuario2, usuario3)
    formacaoLogica.matricular(usuario4, usuario5, usuario6)
    formacaoDesenvolvimento.matricular(usuario7, usuario8)

    println(formacaoKotlin)
    println(formacaoLogica)
    println(formacaoDesenvolvimento)
}