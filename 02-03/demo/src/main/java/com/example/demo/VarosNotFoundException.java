package com.example.demo;

class VarosNotFoundException extends RuntimeException {
    VarosNotFoundException(Long id) {
        super("A város nem található: " + id);
    }
}

