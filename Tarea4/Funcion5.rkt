#lang scheme

(define (contagio grafo n d)
  (if (or (= d -1) (eqv? grafo '()))
      '()
      (if(list? n)
         (if (eqv? n '())
             null
             
             (if (= (car n) (car(car grafo)))
             
                 (map (lambda(x) (cons x (contagio grafo (car(cdr(car grafo))) (- d 1)))) n)
                 (contagio (append (cdr grafo) (list (car grafo))) n d)
                 
                 )
             
             
             )
         (if (= n (car (car grafo)))
             (cons n (contagio (cdr grafo) (car(cdr(car grafo))) (- d 1)))
             (contagio (append (cdr grafo) (list (car grafo))) (cdr n) d)
             
             )
         )
      )
         
      
  )
  