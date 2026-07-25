RPG Game

Um jogo de RPG baseado em turnos desenvolvido em Java.

Sobre:

Um jogo de RPG onde personagens se enfrentam em uma Arena. O jogo conta com heróis e inimigos, cada um com suas próprias habilidades e atributos.

Personagens

Heróis

Mago - possui grimório com feitiços, inventário de itens e mana para usar magias
Guerreiro - possui inventário de itens e bônus de ataque

Inimigos

Orc - possui defesa e pode intimidar os heróis, reduzindo seus atributos
Goblin - possui ouro e pode dropá-lo ao ser derrotado


Sistema de Combate

O combate acontece na Arena entre dois personagens. O sistema de ataque é baseado em um dado de 20 faces:


0 - erra o ataque, nenhum dano causado
1 a 19 - ataque normal, dano calculado com base no dado, força e arma
20 - ataque crítico, dano máximo baseado na força e arma

Além do ataque normal, o Mago pode usar feitiços do seu grimório para causar dano ao inimigo, consumindo mana a cada uso.

Sistema de Defesa

Cada personagem tem uma chance de defender o ataque, evitando completamente o dano. A defesa é baseada em uma chance aleatória.

O Orc possui um atributo especial de defesa que reduz o dano recebido dos ataques.

Inventário

Os heróis (Mago e Guerreiro) podem carregar até 5 itens no inventário. Os itens são usados aleatoriamente e podem ter efeitos especiais, como:

Pocao de Vida - recupera a vida do personagem
Anel da Mente - recupera a mana do Mago

Habilidades Especiais

Mago - usarFeitico() lança um feitiço aleatório do grimório no inimigo
Orc - rage() aumenta sua força e defesa / Intimidacao() reduz força e vida do oponente
Guerreiro - BonusAtk() aumenta seu poder de ataque

Estrutura do Projeto

src/
├── Game/
│   └── Main.java
├── personagens/
│   ├── Personagem.java
│   ├── Mago.java
│   ├── Guerreiro.java
│   ├── Orc.java
│   └── Goblin.java
├── itens/
│   ├── Item.java
│   ├── Arma.java
│   ├── Grimorio.java
│   └── Feitico.java
└── interfaces/
    ├── Heroi.java
    └── Inimigo.java

Conceitos de POO Utilizados

Herança - Mago, Guerreiro, Orc e Goblin herdam de Personagem
Polimorfismo - cada personagem sobrescreve os métodos atacar, defender e mostrarInfo do seu jeito
Encapsulamento - atributos private e protected com acesso via getters e setters
Interfaces - Heroi para os heróis e Inimigo para os inimigos
Composição - Grimorio compõe o Mago, Feitico compõe o Grimorio
Agregação - Arma é agregada ao Personagem, Item é agregado ao inventário
Exceções - tratamento de erros no inventário e uso de itens

Desenvolvedores

Jose Pedro
Built with the support of AI tools.
------------------------------------------------------------------------------------------------------------------------------------------------
-Version in english:

RPG Game

A turn-based RPG game developed in Java.

About:

A RPG game where characters face each other in an Arena. The game features heroes and enemies, each with their own abilities and attributes.

Characters

Heroes

Mago - has a grimoire with spells, item inventory and mana to cast spells
Guerreiro - has an item inventory and attack bonus

Enemies

Orc - has defense and can intimidate heroes, reducing their attributes
Goblin - has gold and can drop it when defeated

Combat System

Combat takes place in the Arena between two characters. The attack system is based on a 20-sided die:

0 - misses the attack, no damage dealt
1 to 19 - normal attack, damage calculated based on the die, strength and weapon
20 - critical attack, maximum damage based on strength and weapon

In addition to the normal attack, the Mago can use spells from his grimoire to deal damage to the enemy, consuming mana with each use.

Defense System

Each character has a chance to defend the attack, completely avoiding the damage. The defense is based on a random chance.

The Orc has a special defense attribute that reduces damage received from attacks.

Inventory

Heroes (Mago and Guerreiro) can carry up to 5 items in their inventory. Items are used randomly and can have special effects, such as:

Pocao de Vida - restores the character's health
Anel da Mente - restores the Mago's mana

Special Abilities

Mago - usarFeitico() casts a random spell from the grimoire on the enemy
Orc - rage() increases his strength and defense / Intimidacao() reduces the opponent's strength and health
Guerreiro - BonusAtk() increases his attack power

Project Structure

src/
├── Game/
│   └── Main.java
├── personagens/
│   ├── Personagem.java
│   ├── Mago.java
│   ├── Guerreiro.java
│   ├── Orc.java
│   └── Goblin.java
├── itens/
│   ├── Item.java
│   ├── Arma.java
│   ├── Grimorio.java
│   └── Feitico.java
└── interfaces/
    ├── Heroi.java
    └── Inimigo.java

OOP Concepts

Inheritance - Mago, Guerreiro, Orc and Goblin inherit from Personagem
Polymorphism - each character overrides the atacar, defender and mostrarInfo methods in their own way
Encapsulation - private and protected attributes with access via getters and setters
Interfaces - Heroi for heroes and Inimigo for enemies
Composition - Grimorio composes Mago, Feitico composes Grimorio
Aggregation - Arma is aggregated to Personagem, Item is aggregated to the inventory
Exceptions - error handling in inventory and item usage

Developers

Jose Pedro
Built with the support of AI tools.
