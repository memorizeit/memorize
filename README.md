Seja bem-vindo(a) ao README do projeto Memorize.

# Objetivo do Projeto #
Construção de um sistema completo, feito em Java, para memorização de conteúdos.

# Commits #
**Padrão**: 
```
#!bash

commit -m "<tipo> <mensagem> <id_tarefa>"
```


O commit segue um padrão, como boa prática de desenvolvimento de software em equipe, para de possibilitar maior rastreabilidade das correções, atualizações e mudanças no projeto. A mensagem também deve ser em inglês, por convenção.


O **<tipo>** refere-se ao tipo de modificação que foi realizada no código, sendo elas:

*  **FIX**: quando é correção de alguma anomalia no software (bug)
*  **NEW**: quando alguma coisa nova é introduzida no código (de preferência, que não seja um bug)


A **<mensagem>** deve ser clara e objetiva, explicando em poucas palavras o que foi realizado.


O **<id_tarefa>** permite saber a qual tarefa essa modificação no projeto está relacionada. Isso ajuda a identificar quem realizou a tarefa e se está mesmo de acordo com o planejado.

**Exemplo de Commit**:

```
#!bash

commit -m "FIX: duplication on save new users [B1234]"
```


# Branchs #
Cada branch deve conter o nome da tarefa que está sendo associada. A master deve ser apenas um espelho, **todo o trabalho é realizado nas branchs** e quando tudo for testado e homologado, então é mesclado na master. Cada merge na master contemplará uma versão estável do sistema.


```
#!bash

$ git clone <projeto>
$ cd <diretorio_do_projeto_apos_clona-lo>
$ git checkout -b <id_tarefa>
$ # trabalhe no projeto
$ git status # verifique as alterações
$ git add <alterações>
$ git commit -m "<tipo> <mensagem> <id_tarefa>"
$ git push -u origin <id_tarefa>
```

Sempre que for trabalhar em uma nova tarefa, use o git pull para atualizar com a master e então criar a nova branch;

# Código #
Todo o código deve ser escrito e documentado em inglês. Para documentação no próprio Java, use a docstring do Java. Basta uma docstring em cada classe e em seus métodos, apenas resumidamente dizendo o que a mesma faz e o que retorna/recebe.

É importante usar boas práticas, padrões de projeto, de arquitetura, segurança e seguir o Clean Code (e Java Code Conventions). Um método, por exemplo, pode ter um nome enorme, desde que seja claro quanto ao que ele faz e fidedigno: 
```
#!java

findNewUsersByAccountUsernameAndEmail(String username, String email)
```