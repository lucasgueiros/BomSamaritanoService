select contribuinte.id,
nome.primeiro_nome,nome.nomes_do_meio,nome.sobrenome,
t.ddd,t.numero,
e.logradouro,e.bairro,e.numero,e.complemento 
from contribuinte 
join nome as nome on nome_id=nome.id 
join telefone as t on t.id=telefone_id 
join endereco as e on e.id=endereco_id;
