class BinTree:

    def __init__(self, left=None, right=None, key="CONS") -> None:
        self.left = left
        self.right = right
        self.key = key

    def __str__(self) -> str:
        lines, *_ = self._display_aux()
        graph = "\n".join(lines)
        as_int = "{:>15}  {:<5}".format("as Integer:", self.toInt())
        as_bool = "{:>15}  {:<5}".format("as Boolean:", self.toBool())
        as_string = "{:>15}  {:<5}".format("as String:",
                                           f"\"{self.toString()}\"")
        return f"\n{graph}\n\n{as_int}\n{as_bool}\n{as_string}\n"

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
        return "True" if value else "False"

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

    def _display_aux(self):
        """Returns list of strings, width, height, and horizontal coordinate of the root."""
        # No child.
        if self.right is None and self.left is None:
            line = '%s' % self.key
            width = len(line)
            height = 1
            middle = width // 2
            return [line], width, height, middle

        # Only left child.
        if self.right is None:
            lines, n, p, x = self.left._display_aux()
            s = '%s' % self.key
            u = len(s)
            first_line = (x + 1) * ' ' + (n - x - 1) * '_' + s
            second_line = x * ' ' + '/' + (n - x - 1 + u) * ' '
            shifted_lines = [line + u * ' ' for line in lines]
            return [first_line, second_line
                    ] + shifted_lines, n + u, p + 2, n + u // 2

        # Only right child.
        if self.left is None:
            lines, n, p, x = self.right._display_aux()
            s = '%s' % self.key
            u = len(s)
            first_line = s + x * '_' + (n - x) * ' '
            second_line = (u + x) * ' ' + '\\' + (n - x - 1) * ' '
            shifted_lines = [u * ' ' + line for line in lines]
            return [first_line, second_line
                    ] + shifted_lines, n + u, p + 2, u // 2

        # Two children.
        left, n, p, x = self.left._display_aux()
        right, m, q, y = self.right._display_aux()
        s = '%s' % self.key
        u = len(s)
        first_line = (x + 1) * ' ' + (n - x -
                                      1) * '_' + s + y * '_' + (m - y) * ' '
        second_line = x * ' ' + '/' + (n - x - 1 + u +
                                       y) * ' ' + '\\' + (m - y - 1) * ' '
        if p < q:
            left += [n * ' '] * (q - p)
        elif q < p:
            right += [m * ' '] * (p - q)
        zipped_lines = zip(left, right)
        lines = [first_line, second_line
                 ] + [a + u * ' ' + b for a, b in zipped_lines]
        return lines, n + m + u, max(p, q) + 2, n + u // 2


# CODE INSERTED HERE

if __name__ == "__main__":
    stack = []
    print(main())