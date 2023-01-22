import { Opportunity } from '../../opportunity/model/opportunity';
import { OportunidadeAceitas } from '../../opportunity/model/oportunidade-aceitas';
export interface User {
  id: number;
  senha: string;
  mail: string;
  telefone: string;
  nome: string;
  sobrenome: string;
  oportunidadeAceitas?: OportunidadeAceitas[];
}
