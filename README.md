# Duh Hotel
Sistema interno de gestão hoteleira desenvolvido em Kotlin para uso de funcionários. Permite controlar reservas de quartos, cadastro de hóspedes, eventos, manutenção de ar‑condicionado, abastecimento e gerar relatórios operacionais, utilizando arquitetura modular e dados em memória.

# Duh Hotel – Plataforma Interna de Operações Hoteleiras

## 📌 Descrição do Projeto
O Hotel Terabithia é uma plataforma interna de gestão desenvolvida em **Kotlin**, destinada ao uso exclusivo de funcionários do hotel.  
O sistema permite o gerenciamento de reservas de quartos, cadastro de hóspedes, eventos, manutenção de ar-condicionado, análise de abastecimento, além da geração de relatórios operacionais consolidados.

O projeto foi desenvolvido seguindo o conceito de **arquitetura modular**, com cada funcionalidade implementada em subprogramas independentes, conforme solicitado no enunciado.

---

## 🎯 Objetivos do Sistema
- Centralizar as operações internas do hotel
- Facilitar o controle de reservas e ocupação
- Gerenciar hóspedes e eventos
- Apoiar decisões operacionais e financeiras
- Consolidar dados em relatórios claros e organizados

---

## 🛠 Tecnologias Utilizadas
- **Linguagem:** Kotlin  
- **IDE:** IntelliJ IDEA  
- **Armazenamento:** Estruturas em memória (listas e arrays)  
- **Paradigma:** Programação modular

---

## 📂 Estrutura do Projeto

Hotel
├── Main.kt
├── auth
│   └── Auth.kt
├── menu
│   └── Menu.kt
├── reservas
│   └── Reservas.kt
├── hospedes
│   └── Hospedes.kt
├── eventos
│   └── Eventos.kt
├── arcondicionado
│   └── ArCondicionado.kt
├── abastecimento
│   └── Abastecimento.kt
├── relatorios
│   └── Relatorios.kt
└── utils
├── Formatacao.kt
└── Validacao.kt

---

## ✅ Funcionalidades Implementadas

### 🔐 Autenticação
- Login com nome de usuário
- Senha fixa com limite de tentativas
- Controle de sessão

### 🏨 Reservas de Quartos
- Cadastro de reservas
- Validação de valores e diárias
- Tipos de quarto (Standard, Executivo e Luxo)
- Controle de ocupação de 20 quartos
- Exibição de mapa de quartos

### 👤 Cadastro de Hóspedes
- Cadastro com limite máximo
- Pesquisa por nome exato e prefixo
- Listagem ordenada
- Atualização e remoção por índice
- Registro de data e hora

### 🎉 Eventos
- Seleção automática de auditório
- Controle de agenda e horários
- Cálculo de garçons
- Cálculo de buffet
- Relatório técnico do evento

### ❄️ Ar-Condicionado
- Comparação de orçamentos de empresas
- Aplicação de descontos
- Cálculo de deslocamento
- Identificação do melhor orçamento

### ⛽ Abastecimento
- Comparação entre postos conveniados
- Análise entre álcool e gasolina
- Cálculo do custo total do abastecimento

### 📊 Relatórios Operacionais
- Total de reservas confirmadas
- Taxa de ocupação do hotel
- Quantidade de hóspedes cadastrados
- Quantidade de eventos confirmados
- Receita de hospedagem
- Receita de eventos
- Receita total consolidada

---

## ▶️ Como Executar o Projeto
1. Abra o projeto no **IntelliJ IDEA**
2. Certifique-se de que o Kotlin está configurado
3. Execute o arquivo `Main.kt`
4. Utilize o menu para navegar entre os módulos

---

## 📄 Observações
- O sistema não utiliza banco de dados
- Todas as informações são mantidas em memória durante a execução
- O projeto segue fielmente os requisitos do enunciado proposto

---

## ✅ Status do Projeto
✔ Concluído  
✔ Funcional  
✔ Modular  
✔ Pronto para entrega
