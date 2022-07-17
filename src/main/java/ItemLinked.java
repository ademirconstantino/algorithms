public class ItemLinked {

   private String nome;
   private ItemLinked prossimo;
   
   public ItemLinked(String nome) {
      this.nome = nome;
   }
   
   public String getNome() {
      return this.nome;
   }
   
   public ItemLinked getProssimo() {
      return this.prossimo;
   }
   
   public void setProssimo(ItemLinked prossimo) {
      this.prossimo = prossimo;
   }
   
   public String toString() {
      return this.nome;
   }

}