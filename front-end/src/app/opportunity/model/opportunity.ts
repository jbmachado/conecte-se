import { User } from '../../user/model/user';
export interface Opportunity {
  //TODO lista de imagem
  id: number;
  criador: User | null;
  titulo: string;
  descricao: string;
  dataCriacao: string;
  endereco: string;
  telefone: string;
  valor: string;
  validade: string;
  categoria: string;
  usuarioAceitosIds: number[];
}
