library(tidyverse)

heap <- read_csv("dados/output.csv", col_names = FALSE)
insertion <- read_csv("dados/output1.csv", col_names = FALSE)
quick <- read_csv("dados/output2.csv", col_names = FALSE)
quick3 <- read_csv("dados/output3.csv", col_names = FALSE)

dados <- rbind(heap, quick, quick3, insertion) %>%
  mutate(algoritmo = X1) %>%
  mutate(tempo = X3) %>%
  mutate(tipo_entrada = ifelse(grepl("quase_ordenado", X2), "Quase Ordenado", 
                               ifelse(grepl("faixa_pequena", X2), "Faixa Pequena", "Faixa Grande"))) %>%
  mutate(tamanho_entrada = ifelse(grepl("10a6", X2), "10⁶", "10⁴")) %>%
  mutate(X1 = NULL) %>%
  mutate(X2 = NULL) %>%
  mutate(X3 = NULL)

