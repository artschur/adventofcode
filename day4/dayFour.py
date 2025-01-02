def readMatrix():
    with open("./input.txt") as file:
        return [line.strip() for line in file]

matrix = readMatrix()

def readColumn(columnIndex):
    row = 0
    column = ''
    for i in range(0, len(matrix)):
        if row >= 0 and columnIndex >= 0:
            column += matrix[row][columnIndex]
            row += 1
    return int(column.count('XMAS') + column.count('SAMX'))

def readRow(rowIndex):
    matrix = readMatrix()
    result = matrix[rowIndex]
    return int(result.count('XMAS') + result.count('SAMX'))


def getDiagonals(matrix):
    n = len(matrix)
    diagonals = []

    for k in range(-n + 1, n):
        diagonal = []
        for i in range(n):
            j = i - k
            if 0 <= j < n:
                if i >= 0 and j >= 0:
                    diagonal.append(matrix[i][j])
        diagonals.append(diagonal)

    return diagonals


def getAntidiagonals(matrix):
    n = len(matrix)
    antidiagonals = []

    for k in range(2 * n - 1):
        antidiagonal = []
        for i in range(n):
            j = k - i
            if 0 <= j < n:
                if i >= 0 and j >= 0:
                    antidiagonal.append(matrix[i][j])
        antidiagonals.append(antidiagonal)

    return antidiagonals


#gets diags and transforms to string for the counting occurences of xmas / samx
antiDiags = getAntidiagonals(matrix)
diags = getDiagonals(matrix)

# added . to separate diagonals and stop counting occurences when they didnt happen
diagStrings = ''
for diag in diags:
    diagStrings += "".join(str(char) for char in diag)
    diagStrings += '.'

antiDiagStrings = ''
for diag in antiDiags:
    antiDiagStrings += "".join(str(char) for char in diag)
    antiDiagStrings += '.'



#reads rowscols from matrix
resultRowsCols = 0
for i in range(0, len(readMatrix())):
    resultRowsCols += (readRow(i) + readColumn(i))

resultAntidiagonals = int(antiDiagStrings.count('XMAS') + antiDiagStrings.count('SAMX'))
resultDiags = int(diagStrings.count('XMAS') + diagStrings.count('SAMX'))

print((resultRowsCols + resultAntidiagonals + resultDiags))

# M S
#  A
# M S
#
# S S
#  A
# M M

def getXmas():
    countXmas = 0
    for row in range(1, len(matrix) - 1 ):
        for col in range(1, len(matrix[0]) - 1):
            if matrix[row][col] == 'A':
                corners = [matrix[row - 1][col - 1], matrix[row - 1][col + 1], matrix[row + 1][col + 1], matrix[row + 1][col - 1]]
                if "".join(corners) in ['MMSS', 'MSSM', 'SSMM', 'SMMS']:
                    countXmas += 1
    return countXmas

print('xmas', getXmas())
