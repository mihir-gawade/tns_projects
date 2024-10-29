# Project Repository

This repository contains two Java projects: a **Banking System** and a **Dice Game**. Each project demonstrates different programming concepts and functionalities.

## Table of Contents
- [1. Banking System](#1-banking-system)
  - [Objective](#objective)
  - [Features](#features)
  - [Entities](#entities)
  - [Relationships Between Entities](#relationships-between-entities)
  - [Class Structures](#class-structures)
  - [Banking Service](#banking-service)
  - [Sample Output](#sample-output)
- [2. Dice Game](#2-dice-game)
  - [Objective](#objective-1)
  - [Features](#features-1)
  - [Gameplay](#gameplay)
  - [Technologies Used](#technologies-used)
  - [Sample Gameplay](#sample-gameplay)
- [Installation](#installation)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

## 1. Banking System

### Objective
Design and implement a banking system using Java that demonstrates Object-Oriented Programming (OOP) concepts, including inheritance, polymorphism, and collections.

### Features
- Manage Customer Details, Account Details, Transactions, and Beneficiaries.
- Users can log in to perform operations like balance checks, deposits, withdrawals, and money transfers.

### Entities
- **Customer**: Represents a bank customer.
- **Account**: Represents a bank account associated with a customer.
- **Transaction**: Represents a financial transaction involving an account.
- **Beneficiary**: Represents a beneficiary added by a customer.

### Relationships Between Entities
- **Customer – Account**: One customer can create multiple accounts (One-to-Many).
- **Customer – Beneficiary**: One customer can add multiple beneficiaries (One-to-Many).
- **Account – Transaction**: An account can have multiple transactions, and a transaction can involve multiple accounts (Many-to-Many).

### Class Structures

#### Customer
- Fields: `customerID`, `name`, `address`, `contact`
- Methods: Getters, Setters, `toString()`

#### Account
- Fields: `accountID`, `customerID`, `type`, `balance`
- Methods: Getters, Setters, `toString()`

#### Transaction
- Fields: `transactionID`, `accountID`, `type`, `amount`, `timestamp`
- Methods: Getters, Setters, `toString()`

#### Beneficiary
- Fields: `beneficiaryID`, `customerID`, `name`, `accountNumber`, `bankDetails`
- Methods: Getters, Setters, `toString()`

### Banking Service
- `BankingService`: Interface defining methods for banking operations.
- `BankingServiceImpl`: Implements the service interface, managing collections of entities and handling operations.


## 2. Dice Game

### Objective
Create a simple dice game where multiple players can roll a dice, and the player with the highest score wins. In case of a tie, all tied players are declared winners.

### Features
- Players can set the number of participants.
- Players roll the dice sequentially.
- Scores are displayed in real-time during the game.
- The scoreboard resets when the game is restarted.

### Gameplay
1. Each player rolls the dice by clicking a button.
2. The score for the player is animated and displayed after each roll.
3. After all players have rolled, the winners are announced.

### Technologies Used
- HTML
- CSS
- JavaScript

### Sample Gameplay
```plaintext
Player 1: Roll the Dice
Player 2: Roll the Dice
...

