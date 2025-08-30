package ada.tech.entity;


import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Petshop {
    private static List<Produto> estoque;
    private static List<Produto> carrinho;

}
