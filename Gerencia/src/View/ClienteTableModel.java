/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Model.cliente.Cliente;


/**
 *
 */
public class ClienteTableModel extends AbstractTableModel{
    private final String[] colunas=new String[]{"#ID","Nome", "Sobrenome", "RG","CPF", "Endereco"};

    private List<Cliente> lista=new ArrayList();

    public ClienteTableModel(List<Cliente> lista){
        this.lista=lista;
    }

    public ClienteTableModel(){
    }


    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
        /*if(column==0)
            return true;
        return false;*/
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente= lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return cliente.getId();
            case 1: return cliente.getNome();//if column 0 (code)
            case 2: return cliente.getSobrenome();//if column 1 (name)
            case 3: return cliente.getRg();//if column 2 (birthday)
            case 4: return cliente.getCpf();
            case 5: return cliente.getEndereco() ;
            default : return null;
        } 
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Cliente cliente = lista.get(row);
        switch (col) {
            case 0:
                cliente.setId((int)value);
                break;
            case 1:
                cliente.setNome((String) value); //if column 0 (code)
                break;
            case 2:
                cliente.setSobrenome((String) value);
                break;
            case 3:
                cliente.setRg((String) value);
                break;
            case 4:
                cliente.setCpf((long) value);
                break;
            case 5:
                cliente.setEndereco((String) value);
                break;
            default:
        }
        this.fireTableCellUpdated(row, col);
    }

    public boolean removeCliente(Cliente cliente) {
        int linha = this.lista.indexOf(cliente);
        boolean result = this.lista.remove(cliente);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

    public void adicionaCliente(Cliente cliente) {
        this.lista.add(cliente);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }   
    
    
    public void setListaCliente(List<Cliente> clientes) {
        this.lista = clientes;
        this.fireTableDataChanged();
        //this.fireTableRowsInserted(0,contatos.size()-1);//update JTable
    }

    public void limpaTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }

    public Cliente getCliente(int linha){
        return lista.get(linha);
    }

    public void removeClientes(List<Cliente> listaParaExcluir) {
        listaParaExcluir.forEach((clientes) -> {
            removeCliente(clientes);
        });
    }
}
    
