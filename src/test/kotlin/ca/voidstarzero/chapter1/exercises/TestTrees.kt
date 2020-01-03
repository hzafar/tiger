package ca.voidstarzero.chapter1.exercises

val tree1: Tree<String> =
    Tree(
        left = Tree(key = "a", binding = ""),
        key = "h", binding = "",
        right = Tree(key = "z", binding = "")
    )

val tree2: Tree<Int> =
    Tree(
        key = "u", binding = 830,
        right = Tree(
            key = "v", binding = 341,
            right = Tree(
                key = "w", binding = 18,
                right = Tree(
                    key = "x", binding = 831,
                    right = Tree(
                        key = "y", binding = 648,
                        right = Tree(
                            key = "z", binding = 117
                        )
                    )
                )
            )
        )
    )
