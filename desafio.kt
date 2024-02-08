// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, var email: String, var idade: Int) {
    fun atualizarEmail(novoEmail: String) {
        this.email = novoEmail
    }

    fun atualizarIdade(novaIdade: Int) {
        this.idade = novaIdade
    }
}

data class ConteudoEducacional(
    var nome: String,
    var duracao: Int = 60,
    var descricao: String = ""    
) {
    fun atualizarDuracao(novaDuracao: Int) {
        this.duracao = novaDuracao
    }

    fun atualizarDescricao(novaDescricao: String) {
        this.descricao = novaDescricao
    }   
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)            
            println("Usuário ${usuario.nome} matriculado na formação '$nome' (Nível: $nivel).")
        } else {
            println("Usuário ${usuario.nome} já matriculado nesta formação.")
        }
    }   

    fun listarInscritos(): List<Usuario> {
        return inscritos.toList()
    }  
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 120)
    val formacao = Formacao("Formação em Ciência da Computação", listOf(conteudo1, conteudo2), Nivel.INTERMEDIARIO)

    val usuario1 = Usuario("Alice", "alice@example.com", 25)
    val usuario2 = Usuario("Bob", "bob@example.com", 30)

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)   
}
