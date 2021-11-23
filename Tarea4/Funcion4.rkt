#lang scheme

(define (vida h arbol)
  (if (eqv? '() arbol )
      #f
      (if (= (car arbol) h)
          '()
          (if (list? (vida h (car(cdr arbol))))
              (cons (car arbol) (vida h (car(cdr arbol))))
              (if (list? (vida h (car(cdr(cdr arbol)))))
                  (cons(car arbol) (vida h (car(cdr (cdr arbol)))))
                  #f
                  )
              )
          )
      )
  




  )

