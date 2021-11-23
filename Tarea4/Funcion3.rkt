#lang scheme

(define (zeta_simple i s)
  (if (list? i)
      (if (= (car i) (car(cdr i)))
          (/ 1 (expt (car(cdr i)) s))
          (+ (/ 1 (expt (car(cdr i)) s)) (zeta_simple (list (car i) (+ (car (cdr i))1)) s))
          )
      (+ 1 (zeta_simple (list i 2) s))
      )
  )