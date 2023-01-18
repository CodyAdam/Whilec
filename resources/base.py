class BinTree:

    def __init__(self, left=None, right=None, key="CONS") -> None:
        self.left = left
        self.right = right
        self.key = key

    def __str__(self) -> str:
        return self.pp()

    def pp(self) -> str:
        if self.key == "NIL":
            return "nil"
        elif self.key == "CONS":
            if self.left.key == "int":
                return str(self.right.toInt())
            elif self.left.key == "bool":
                return "true" if self.right.toBool() else "false"
            elif self.left.key == "string":
                return self.right.toString()
            else:
                return f"(cons {self.left.pp()} {self.right.pp()})"
        else:
            return self.key

    def toInt(self):
        value = 0
        cursor = self
        if cursor.key == "CONS":
            value += 1
        while cursor.right:
            cursor = cursor.right
            if cursor.key == "CONS":
                value += 1
        return value

    def toBool(self):
        value = False
        cursor = self
        if cursor.key == "CONS":
            value = True
        return value

    def toString(self):
        value = ""
        cursor = self

        if cursor.key == "CONS":
            if cursor.left:
                value += cursor.left.toString()
            if cursor.right:
                value += cursor.right.toString()
        else:
            if cursor.key != "NIL":
                value += cursor.key
        return f"{value}"


# CODE INSERTED HERE

if __name__ == "__main__":
    stack = []
    for i, value in enumerate(main()):
        print(i,":", value)
