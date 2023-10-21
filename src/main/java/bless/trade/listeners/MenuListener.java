package bless.trade.listeners;

import bless.trade.Trade;
import bless.trade.commands.TradeComand;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import static bless.trade.commands.TradeComand.inven1;
import static bless.trade.commands.TradeComand.inven2;

public class MenuListener implements Listener {

    int[] slots1 = new int[16];
    int[] slots2 = new int[16];


    @EventHandler
    public void onMenuCLick(InventoryClickEvent e) throws InterruptedException {

        boolean first = false;

        Map<String, int[]> map = new TreeMap<String, int[]>();

        Player p1 = null;
        Player p2 = null;

        slots1[0] = 0;
        slots1[1] = 1;
        slots1[2] = 2;
        slots1[3] = 3;
        slots1[4] = 9;
        slots1[5] = 10;
        slots1[6] = 11;
        slots1[7] = 12;
        slots1[8] = 18;
        slots1[9] = 19;
        slots1[10] = 20;
        slots1[11] = 21;
        slots1[12] = 27;
        slots1[13] = 28;
        slots1[14] = 29;
        slots1[15] = 30;

        slots2[0] = 5;
        slots2[1] = 6;
        slots2[2] = 7;
        slots2[3] = 8;
        slots2[4] = 14;
        slots2[5] = 15;
        slots2[6] = 16;
        slots2[7] = 17;
        slots2[8] = 23;
        slots2[9] = 24;
        slots2[10] = 25;
        slots2[11] = 26;
        slots2[12] = 32;
        slots2[13] = 33;
        slots2[14] = 34;
        slots2[15] = 35;

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.GRAY + "You                   " + Trade.p2.getDisplayName())){
            if(e.getCurrentItem().getType() == Material.ORANGE_TERRACOTTA){
                inven2.setItem(41,new ItemStack(Material.LIME_DYE));
                if(e.getClickedInventory().getItem(41).getType() == Material.LIME_DYE){
                    Trade.close = Boolean.FALSE;
                    System.out.println("traded");
                    for (int i = 0; i < slots2.length; i++) {
                        if(e.getInventory().getItem(slots2[i]) != null){
                            e.getWhoClicked().getInventory().addItem(e.getInventory().getItem(slots2[i]));
                            e.getInventory().removeItem(e.getInventory().getItem(slots2[i]));
                            if(inven2.getItem(slots1[i]) != null){
                                inven2.removeItem(inven2.getItem(slots1[i]));
                            }
                        }
                    }
                    Trade.p2.closeInventory();
                    e.getWhoClicked().closeInventory();
                }
            }
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.GRAY + "You                   " + Trade.p1.getDisplayName())){
            if(e.getCurrentItem().getType() == Material.ORANGE_TERRACOTTA){
                inven1.setItem(41,new ItemStack(Material.LIME_DYE));
                if(e.getClickedInventory().getItem(41).getType() == Material.LIME_DYE){
                    Trade.close = Boolean.FALSE;
                    System.out.println("traded");
                    for (int i = 0; i < slots2.length; i++) {
                        if(e.getInventory().getItem(slots2[i]) != null){
                            e.getWhoClicked().getInventory().addItem(e.getInventory().getItem(slots2[i]));
                            e.getInventory().removeItem(e.getInventory().getItem(slots2[i]));
                            if(inven1.getItem(slots1[i]) != null){
                                inven1.removeItem(inven1.getItem(slots1[i]));
                            }
                        }
                    }
                    Trade.p1.closeInventory();
                    e.getWhoClicked().closeInventory();
                }
            }
            e.setCancelled(true);
        }
        if(e.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.GRAY + "You                   " + Trade.p2.getDisplayName())){
            if(e.getCurrentItem() == null){ return; }
            if(e.getClickedInventory() == e.getInventory()){ return; }

            for (int i = 0; i < slots1.length; i++) {
                if(e.getInventory().getItem(slots1[i]) == null && e.getCurrentItem() != null){
                    ItemStack item = e.getCurrentItem();
                    for (int z = 0; z < slots2.length; z++) {
                        if(e.getInventory().getItem(slots2[i]) == null){
                            inven2.setItem(slots2[i], item);
                        }
                    }
                    e.getInventory().setItem(slots1[i],item);
                    e.getWhoClicked().getInventory().removeItem(item);
                    e.getInventory().setItem(39,new ItemStack(Material.ORANGE_TERRACOTTA));
                }
                e.setCancelled(true);
            }
        }
        if(e.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.GRAY + "You                   " + Trade.p1.getDisplayName())){
            if(e.getCurrentItem() == null){ return; }
            if(e.getClickedInventory() == e.getInventory()){ return; }

            Trade.p2 = (Player) e.getWhoClicked();

            for (int i = 0; i < slots1.length; i++) {
                if(e.getInventory().getItem(slots1[i]) == null && e.getCurrentItem() != null){
                    ItemStack item = e.getCurrentItem();
                    for (int z = 0; z < slots2.length; z++) {
                        if(e.getInventory().getItem(slots2[i]) == null){
                            inven1.setItem(slots2[i], item);
                        }
                    }
                    e.getInventory().setItem(slots1[i],item);
                    e.getWhoClicked().getInventory().removeItem(item);
                    e.getInventory().setItem(39,new ItemStack(Material.ORANGE_TERRACOTTA));
                }
                e.setCancelled(true);
            }
        }
    }
}
