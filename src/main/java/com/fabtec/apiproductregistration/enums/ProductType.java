package com.fabtec.apiproductregistration.enums;

public enum ProductType {

	ANEIS(1),
	ACESSORIOS_GAME(2),
	BATOM(3),
	BICICLETA(4),
	BOLA(5),
	BRACADEIRA(6),
	BRINCOS(7),
	CARNE(8),
	CEREAIS(9),
	CERVEJA(10),
	CHINELOS(11),
	CHUTEIRA(12),
	COLAR(13),
	CONSOLE(14),
	COMPUTADOR(15),
	DESTILADOS(16),
	ENERGETICO(17),
	FILME_ROMANCE(18),
	FILME_FICCAO(19),
	FILME_AVENTURA(20),
	FILME_TERROR(21),
	FILME_ASSASSINATO(22),
	FRUTAS(23),
	GARGANTILHA(24),
	GRAOS(25),
	HQ(26),
	JOGOS_PS(27),
	JOGOS_XBOX(28),
	LATICINIOS(29),
	LIVRO_ROMANCE(30),
	LIVRO_FICCAO(31),
	LIVRO_AVENTURA(32),
	LIVRO_TERROR(33),
	LIVRO_ASSASSINATO(34),
	MANGA(35),
	MASSAS(36),
	OCULOS(37),
	OCULOS_ESCURO(38),
	PENTE(39),
	PERFUME(40),
	PULSEIRA(41),
	QUADRINHOS(42),
	RAQUETE(43),
	RATEIRINHA(44),
	RELOGIO(45),
	SALTO(46),
	SAPATOS(47),
	SMARTPHONES(48),
	SUCO(49),
	TAMANCO(50),
	TELEVISAO(51),
	TENIS(52),
	VINHO(53);
	
	private int typeCode;

	private ProductType(int typeCode) {
		this.typeCode = typeCode;
	}

	public int getTypeCode() {
		return typeCode;
	}
	
	public static ProductType valueOf(int typeCode) {
		for(ProductType value : ProductType.values()) {
			if(typeCode == value.getTypeCode()) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid status code");
	}
}
