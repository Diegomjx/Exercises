# Password Evaluation Tool

## Introduction
This project includes a password evaluation tool that assesses password strength based on various criteria and checks if a given password exists in known wordlists.

## Prerequisites
- Java 8 or later
- Command-line access
- Wordlist files (`rockyou.txt.gz`, `english.txt`, etc.) available in the `wordlists` directory

## Setup

### Step 1: Uncompress the Wordlist
To use the `rockyou.txt` wordlist, it must first be decompressed. Run the following command in your terminal:

```bash
gunzip rockyou.txt.gz
```
This will extract the rockyou.txt file into the wordlists directory.

### Step 2: Ensure Wordlist Directory Structure
Ensure that your wordlists are placed in a directory called wordlists at the root of the project. Example structure:

```css
project-root/
├── src/
├── wordlists/
│   ├── rockyou.txt
│   ├── english.txt
│   └── shortKrak.txt
└── README.md
```
### 3: Compile the Program
Navigate to the source directory and compile the program using the following command:

``` bash
javac Secure_Password.java
```
### Step 4: Run the Program
Run the program and input a password for evaluation:

```bash
java Secure_Password
```
### Features
Password Strength Evaluation:

Checks for length, uppercase, lowercase, numbers, and special characters.
Assigns a score to the password and provides a feedback level: LOW, MEDIUM, HIGH, INSANE.
Wordlist Matching:

Validates if the password exists in common wordlists (e.g., rockyou.txt).
Displays the number of wordlists in which the password appears.

