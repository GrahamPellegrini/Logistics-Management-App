<h1 align="center">Logistics Management Application – OOP Coursework</h1>

<p align="center">
  <a href="https://www.um.edu.mt/courses/studyunit/CPS2004">
    <img src="https://img.shields.io/badge/University%20of%20Malta-CPS2004-blue?style=for-the-badge" alt="CPS2004">
  </a>
  <a href="https://github.com/GrahamPellegrini/OOP-Learning">
    <img src="https://img.shields.io/badge/Project-Logistics%20Management-green?style=for-the-badge" alt="Logistics Management">
  </a>
  <a href="https://www.um.edu.mt/profile/markvella">
    <img src="https://img.shields.io/badge/Supervisor-Dr.%20Mark%20Vella-lightgrey?style=for-the-badge" alt="Supervisor">
  </a>
</p>

---

## Overview

This repository contains a **multi-language Logistics Management System** developed in **Java** and **C++**, submitted for the [CPS2004 Object Oriented Programming](https://www.um.edu.mt/courses/studyunit/CPS2004) unit at the University of Malta.

The system handles:
- Product management with 12+ specialised subclasses
- Transport services via Factory Pattern
- Shipment tracking using Decorator Pattern
- Portable persistence via Protocol Buffers
- gRPC-based distributed computation for remote stock valuation

Each section is modularised and includes both source code and build instructions.

---

## Project Structure

```
OOP-Learning/
├── Q1_Java/          # Java CLI-based product, transport & shipment management system
│   └── src/
├── Q1_Cpp/           # C++ CLI system mirroring Java hierarchy
│   ├── include/
│   ├── src/
│   └── CMakeLists.txt
├── Q2/               # Java enhancements using Factory & Decorator Patterns
├── Q3/               # Java ProtoBuf serialization logic + Stock Viewer in C++
├── Q3_Cpp/           # C++ implementation of the Asset Viewer app
├── Q4/               # gRPC-based Java remote computation service
├── CPS2004 Assignment 2024.pdf
├── cps2004_sept_requirments.pdf
└── README.md
```

---

## Technologies

- Java 17 (Maven)
- C++20 (CMake)
- Protocol Buffers (Java/C++ serialization)
- gRPC (Remote asset valuation)
- UML: Lucidchart Diagrams

---

## Functional Highlights

### Q1 – Core Application (Java & C++)
- CLI app for managing Products, Transports, Shipments, Customers
- Product Hierarchy with 12+ subclasses (Books, Electronics, Clothing, etc.)
- Shipment calculations: total cost, delivery estimates
- C++ version mirrors Java structure with OOP principles

### Q2 – Design Patterns
- **Factory Pattern** for flexible creation of products and transport objects
- **Decorator Pattern** for runtime shipment enhancements:
  - Global discount decorator
  - Route adjustment decorator

### Q3 – Data Persistence
- Protocol Buffers to serialize/deserialize application state
- Save/load functionality with `convertToData()` and `convertFromData()`
- Java → Proto files and code generation
- **C++ Stock Viewer** using reused CLI logic

### Q4 – Distributed Computing with gRPC
- Java gRPC server for remote calculation of `Stock` annual returns
- Client implemented in C++ as required by assignment
- gRPC protos, stub generation, and integration with the Portfolio class

---

## Build Instructions

### Java (Maven)
```bash
cd Q1_Java/
mvn clean install
# Run CLI.java main class
```

### C++ (CMake)
```bash
cd Q1_Cpp/
cmake .
make
./CLI
```

> Ensure C++20-compatible compiler and Maven 3+ are installed.

---

## Report & Assignment References

- Project Report: [`CPS2004 Assignment 2024.pdf`](CPS2004 Assignment 2024.pdf)
- September Requirements Spec: [`cps2004_sept_requirments.pdf`](cps2004_sept_requirments.pdf)

> Note : The requirements implemented reflect the **June session specification**, which was **more complex and in-depth** than the **September session specification** actually found in the repository.

---

## Author

**Graham Pellegrini**  
B.Sc. (Hons.) Computer Engineering  
University of Malta  
GitHub: [@GrahamPellegrini](https://github.com/GrahamPellegrini)
