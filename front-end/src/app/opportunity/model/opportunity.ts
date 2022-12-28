import { User } from '../../user/model/user';
export interface Opportunity {
  //TODO lista de imagem
  //TODO oportunidade aceitas
  _id: number;
  criador: User;
  titulo: string;
  descricao: string;
  dataCriacao: string;
  endereco: string;
  telefone: string;
  valor: string;
  validade: string;
  categoria: string;
}
