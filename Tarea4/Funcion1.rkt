#lang scheme

(define (mazo cartas divisor)
  (if (null? cartas)
      '()
      (if(= (modulo (car cartas) divisor) 0)
         (cons (car cartas) (mazo (cdr cartas) divisor))
         (mazo (cdr cartas) divisor)
         )
      )
  )