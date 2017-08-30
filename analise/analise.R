library(tidyverse)

heap <- read_csv("dados/output.csv", col_names = FALSE)
insertion <- read_csv("dados/output1.csv", col_names = FALSE)
quick <- read_csv("dados/output2.csv", col_names = FALSE)
quick3 <- read_csv("dados/output3.csv", col_names = FALSE)

dados <- rbind(heap, quick, quick3, insertion) %>%
  mutate(algoritmo = X1) %>%
  mutate(tempo = X3) %>%
  mutate(tempoSeg = tempo / 10**9) %>%
  mutate(tipo_entrada = ifelse(grepl("quase_ordenado", X2), "Quase Ordenado", 
                               ifelse(grepl("faixa_pequena", X2), "Faixa Pequena", "Faixa Grande"))) %>%
  mutate(tamanho_entrada = ifelse(grepl("10a6", X2), "10^6", "10^4")) %>%
  mutate(X1 = NULL) %>%
  mutate(X2 = NULL) %>%
  mutate(X3 = NULL)

ggplot(data = dados, aes(x = algoritmo, y = tempo)) +
  geom_boxplot()

ggplot(data = dados %>% subset(algoritmo != "InsertionSort"), aes(x = algoritmo, y = tempo)) +
  geom_boxplot()

ggplot(data = dados %>% subset(algoritmo == "InsertionSort"), aes(x = tipo_entrada, y = tempo)) +
  geom_boxplot() +
  xlab("InsertionSort")

ggplot(data = dados %>% subset(algoritmo == "InsertionSort"), aes(x = tipo_entrada, y = tempo)) +
  geom_boxplot() +
  xlab("InsertionSort")

ggplot(data = dados %>% subset(algoritmo == "QuickSort"), aes(x = tipo_entrada, y = tempo)) +
  geom_boxplot() +
  xlab("QuickSort")

ggplot(data = dados %>% subset(algoritmo == "HeapSort"), aes(x = tipo_entrada, y = tempo)) +
  geom_boxplot() +
  xlab("HeapSort")

ggplot(data = dados %>% subset(algoritmo == "Quick3WaySort"), aes(x = tipo_entrada, y = tempo)) +
  geom_boxplot() +
  xlab("Quick3WaySort")

ggplot(data = dados, aes(x = tamanho_entrada, y = tempo)) +
  geom_boxplot()

ggplot(data = dados %>% subset(algoritmo == "InsertionSort"), aes(x = tamanho_entrada, y = tempo)) +
  geom_boxplot() +
  xlab("InsertionSort")

ggplot(data = dados %>% subset(algoritmo == "QuickSort"), aes(x = tamanho_entrada, y = tempo)) +
         geom_boxplot() +
         xlab("QuickSort")

ggplot(data = dados %>% subset(algoritmo == "HeapSort"), aes(x = tamanho_entrada, y = tempo)) +
  geom_boxplot() +
  xlab("HeapSort")

ggplot(data = dados %>% subset(algoritmo == "Quick3WaySort"), aes(x = tamanho_entrada, y = tempo)) +
  geom_boxplot() +
  xlab("Quick3WaySort")

summary((dados %>% subset(algoritmo == "InsertionSort"))$tempoSeg)
summary((dados %>% subset(algoritmo == "QuickSort"))$tempoSeg)
summary((dados %>% subset(algoritmo == "HeapSort"))$tempoSeg)
summary((dados %>% subset(algoritmo == "Quick3WaySort"))$tempoSeg)


aov <- aov(tempo ~ algoritmo *  tamanho_entrada * tipo_entrada, dados)  
summary(aov)

5.274e+22 + 1.813e+22 + 7.135e+21 + 5.268e+22 + 2.199e+22 + 7.135e+21 + 2.197e+22 + 2.474e+19

soma = 1.818047e+23

algoritmo = 5.274e+22/soma
tamanho = 1.813e+22/soma
tipo = 7.135e+21/soma
algo_tamanho = 5.268e+22/soma
algo_tipo = 2.199e+22/soma
tam_tipo = 7.135e+21/soma
algo_tipo_tam = 2.197e+22/soma
erros = 2.474e+19/soma

ggplot(data = dados, aes(y = tempo, x=tamanho_entrada)) +
  geom_boxplot() +
  facet_wrap(~algoritmo)

ggplot(data = dados, aes(y = tempo, x=tipo_entrada)) +
  geom_boxplot() +
  facet_wrap(~algoritmo)

ggplot(data = dados, aes(y = tempo, x=tipo_entrada)) +
  geom_boxplot() +
  facet_wrap(~tamanho_entrada) +
  facet_wrap(~algoritmo)

Foram realmente importantes os fatores "algoritmo", "tamanho do dado" 
e as seguintes interações: "algoritmo" e "tamanho do dado", "algoritmo" 
e "tipo de dado de entrada" e também a interação entre os três fatores.


