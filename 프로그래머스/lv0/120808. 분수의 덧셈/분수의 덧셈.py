from fractions import Fraction

def solution(numer1, denom1, numer2, denom2):
    answer = []
    result = Fraction(numer1, denom1) + Fraction(numer2, denom2)

    answer.append(result.numerator)
    answer.append(result.denominator)
    return answer