#lang scheme
(define (transformacion funcion1 funcion2 numeros)
  (if (null? numeros)
      '()
      (if (>= (funcion1 (funcion2 (car numeros))) (funcion2(funcion1(car numeros))))
              (cons (funcion1 (funcion2 (car numeros))) (transformacion funcion1 funcion2 (cdr numeros)))
              (cons (funcion2 (funcion1 (car numeros))) (transformacion funcion1 funcion2 (cdr numeros)))

          )


  )
)