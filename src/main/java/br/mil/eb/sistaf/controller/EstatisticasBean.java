package br.mil.eb.sistaf.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.mil.eb.sistaf.model.Mencao;
import br.mil.eb.sistaf.model.Resultado;
import br.mil.eb.sistaf.repository.ResultadosFinais;
import br.mil.eb.sistaf.resository.filter.ResultadoFinalFilter;
import br.mil.eb.sistaf.service.NegocioException;

 


@Named
@ViewScoped
public class EstatisticasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Produces
	private Resultado resultado;

	@Inject
	private ResultadosFinais resultados;
	private List<Resultado> resultadosFiltrados;
	
	private ResultadoFinalFilter filtro;
	
	private BarChartModel barModel;
	
	private int[] arrayMencoes = {0, 0, 0, 0, 0, 0, 0};
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
 
    private BarChartModel initBarModel() {
        
    	BarChartModel model = new BarChartModel();
    	model.setShowPointLabels(true);
 
        ChartSeries indicesAlcancados = new ChartSeries();
        indicesAlcancados.setLabel("Menções");
        indicesAlcancados.set("Insuficiente", arrayMencoes[0]);
        indicesAlcancados.set("Regular", arrayMencoes[1]);
        indicesAlcancados.set("Bom", arrayMencoes[2]);
        indicesAlcancados.set("Muito Bom", arrayMencoes[3]);
        indicesAlcancados.set("Excelente", arrayMencoes[4]);
        indicesAlcancados.set("Apenas Suficiência", arrayMencoes[5]);
        indicesAlcancados.set("Não Realizado", arrayMencoes[6]);
 
        model.addSeries(indicesAlcancados);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Menções X Militares");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        //xAxis.setLabel("Menção");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        //yAxis.setLabel("Quantidade");
        yAxis.setMin(0);
        yAxis.setMax(50);
        yAxis.setTickCount(6);
    }
     
    
	
	public EstatisticasBean() throws NegocioException{
		filtro = new ResultadoFinalFilter();
	}
	
	
	/* aqui vc colocar codigos antes do renderizar, ex... preencher um combobox, etc */
	public void inicializar() throws NegocioException{

		if (this.resultado == null) {
			limpar();
		} 		
	}
	
	
	
	
	
	public void buscar(){
		
		resultadosFiltrados = resultados.filtrados(filtro);
		
		arrayMencoes[0] = 0;
		arrayMencoes[1] = 0;
		arrayMencoes[2] = 0;
		arrayMencoes[3] = 0;
		arrayMencoes[4] = 0;
		arrayMencoes[5] = 0;
		arrayMencoes[6] = 0;
		
		for(Resultado resultado : resultadosFiltrados){
			if(resultado.getMencao()==Mencao.INSUFICIENTE.getIndice()){
				arrayMencoes[0]++;
			}
			if(resultado.getMencao()==Mencao.REGULAR.getIndice()){
				arrayMencoes[1]++;
			}
			if(resultado.getMencao()==Mencao.BOM.getIndice()){
				arrayMencoes[2]++;
			}
			if(resultado.getMencao()==Mencao.MUITO_BOM.getIndice()){
				arrayMencoes[3]++;
			}
			if(resultado.getMencao()==Mencao.EXCELENTE.getIndice()){
				arrayMencoes[4]++;
			}
			if(resultado.getMencao()==Mencao.SUFICIENTE.getIndice()){
				arrayMencoes[5]++;
			}
			if(resultado.getMencao()==Mencao.INEXISTENTE.getIndice()){
				arrayMencoes[6]++;
			}
		}
		createBarModel();
		
	}	
	private void limpar(){
		this.resultado = new Resultado();
	}
	public Resultado getResultado() {
		return resultado;
	}
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	public ResultadosFinais getResultados() {
		return resultados;
	}
	public void setResultados(ResultadosFinais resultados) {
		this.resultados = resultados;
	}
	public List<Resultado> getResultadosFiltrados() {
		return resultadosFiltrados;
	}
	public void setResultadosFiltrados(List<Resultado> resultadoLista) {
		this.resultadosFiltrados = resultadoLista;
	}
	public ResultadoFinalFilter getFiltro() {
		return filtro;
	}
	public void setFiltro(ResultadoFinalFilter filtro) {
		this.filtro = filtro;
	}

}