package com.freezlex.kohanato

import com.freezlex.kohanato.core.KohanatoCore

/**
 * Main application launcher
 */
fun main() {
    KohanatoCore()
        .defineOwners(306703362261254154)
        .commandsPackage("com.freezlex.kohanato.commands")
        .processByEnv()
        .launch()
}
