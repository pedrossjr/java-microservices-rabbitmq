package io.github.pedrossjr.pedidos.processador.service;

import io.github.pedrossjr.pedidos.processador.entity.ItemPedido;
import io.github.pedrossjr.pedidos.processador.entity.Pedido;
import io.github.pedrossjr.pedidos.processador.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public List<ItemPedido> save(List<ItemPedido> itens) {
        return itemPedidoRepository.saveAll(itens);
    }

    public void save(ItemPedido item) {
        itemPedidoRepository.save(item);
    }

    public void updatedItemPedido(List<ItemPedido> itemPedidos, Pedido pedido) {

        itemPedidos.forEach(item -> {
            item.setPedido(pedido); // formando o item o seu pedido
            this.save(item);
        });
    }
}
